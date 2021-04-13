package com.example.proejto_desafio.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.proejto_desafio.R
import com.example.proejto_desafio.modelo.Cor

class corAdapter(private var cadastro: corCadastro, private var context: Context): BaseAdapter() {

    fun adicionar(cor: Cor){
        this.cadastro.adicionar(cor)
    }

    fun atualizar(cor: Cor, indice: Int){
        this.cadastro.atualizar(cor, indice)
    }

    fun setListaCor(novaListaCor: ArrayList<Cor>){
        this.cadastro.setCor(novaListaCor)
    }

    fun deletarCorPorIndice(indice: Int){
        this.cadastro.deletar(indice)
    }

    override fun getCount(): Int {
        return this.cadastro.quantos()
    }

    override fun getItemId(indice: Int): Long {
        return this.cadastro.getCorPosicao(indice).toString().toLong()
    }

    override fun getItem(indice: Int): Any {
        return this.cadastro.getCorPosicao(indice)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var myCor = this.cadastro.getCorPosicao(position)
        var vw : View

        vw = if(convertView == null){
            var valor = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            valor.inflate(R.layout.listadecores, null)


        }
        else{
            convertView
        }

        var cor = vw.findViewById<ImageView>(R.id.imagemCor)
        var nome = vw.findViewById<TextView>(R.id.nomeCor)
        var codigo = vw.findViewById<TextView>(R.id.codigoCor)

        cor.setColorFilter(myCor.codigo)
        nome.setText(myCor.nome)
        codigo.setText(myCor.codigo)

        return vw
    }
}