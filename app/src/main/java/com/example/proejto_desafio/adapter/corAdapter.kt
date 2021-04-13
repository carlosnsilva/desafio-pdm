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

    fun quantidade() {
        return this.cadastro.quantos()
    }
        
    fun buscaPorIndice(indice: Int): Cor{
        return this.cadastro.getCorPosicao(indice)
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var myCor = this.cadastro.getCorPosicao(position)
        var vw : View

        if(convertView == null){
            var valor = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            valor.inflate(R.layout.listaDeCores, null)


        }
        else{
            vw = convertView
        }

        var id = vw.findViewById<ImageView>()
        var nome = vw.findViewById<TextView>()
        var codigo = vw.findViewById<TextView>()

        id.setColorFilter(myCor.codigo)
        nome.text(myCor.nome)
        codigo.text(myCor.codigo)

        return vw
    }
}