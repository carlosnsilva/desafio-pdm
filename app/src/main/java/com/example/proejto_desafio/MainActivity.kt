package com.example.proejto_desafio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ListView
import com.example.proejto_desafio.DAO.coresDAO
import com.example.proejto_desafio.adapter.corAdapter
import com.example.proejto_desafio.adapter.corCadastro
import com.example.proejto_desafio.modelo.Cor
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var listaCores: ListView
    private lateinit var botaoAdicionar: FloatingActionButton
    private lateinit var cadastroCor: corCadastro
    private lateinit var coresDAO: coresDAO
    private lateinit var cores: ArrayList<Cor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.coresDAO = coresDAO(this)
        this.cadastroCor = corCadastro()
        this.listaCores = findViewById(R.id.listaCores)
        this.botaoAdicionar = findViewById(R.id.addButton)
        this.listaCores.adapter = corAdapter(cadastroCor, this)
        this.listaCores.onItemClickListener = click()
        this.listaCores.onItemLongClickListener = clickLongo()
        this.botaoAdicionar.setOnClickListener(clickBotaoAdicionar())
        this.cores = this.coresDAO.select()
        (this.listaCores.adapter as corAdapter).setListaCor(cores)
    }

    inner class clickBotaoAdicionar(): View.OnClickListener{
        override fun onClick(v: View?) {
            val intent = Intent(this@MainActivity,formActivity::class.java )
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // adicionando
        if (resultCode == Activity.RESULT_OK && requestCode == 1){
            var valor = data?.getSerializableExtra("Cor") as Cor

            (this.listaCores.adapter as corAdapter).adicionar(valor)
            (this.listaCores.adapter as corAdapter).notifyDataSetChanged()
        }

        //atualizacao
        else if(resultCode == Activity.RESULT_OK && requestCode == 2){
            var valor = data?.getSerializableExtra("Cor") as Cor
            var indice = data?.getIntExtra("lista_de_cores",0)

            (this.listaCores.adapter as corAdapter).atualizar(valor,indice)
            (this.listaCores.adapter as corAdapter).notifyDataSetChanged()
        }
    }

    inner class click(): AdapterView.OnItemClickListener{
        override fun onItemClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {

            var valor = this@MainActivity.listaCores.adapter.getItem(position) as Cor
            var intent = Intent(this@MainActivity, formActivity::class.java)
            intent.putExtra("cor_enviada", valor)
            intent.putExtra("cor_lista", position)

            startActivityForResult(intent, 2)
        }
    }

    inner class clickLongo(): AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ): Boolean {
            var valor = this@MainActivity.listaCores.adapter.getItem(position) as Cor
            this@MainActivity.coresDAO.delete(valor.id)
            (this@MainActivity.listaCores.adapter as corAdapter).deletarCorPorIndice(position)
            (this@MainActivity.listaCores.adapter as corAdapter).notifyDataSetChanged()

            return true
        }
    }
}