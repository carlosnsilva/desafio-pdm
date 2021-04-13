package com.example.proejto_desafio.adapter

import com.example.proejto_desafio.modelo.Cor


class corCadastro {

    private var corLista: ArrayList<Cor> = arrayListOf()



    fun getCor(): ArrayList<Cor>{
        return this.corLista
    }

    fun setCor(novaCorLista: ArrayList<Cor>){
        this.corLista = novaCorLista
    }

    fun adicionar(cor: Cor){
        this.corLista.add(cor)
    }

    fun atualizar(cor: Cor, indice: Int){
        this.corLista[indice] = cor
    }

    fun deletar(indice: Int){
        this.corLista.removeAt(indice)
    }

    fun quantos(): Int{
        return this.corLista.count()
    }

    fun getCorPosicao(indice: Int): Cor{
        return this.corLista[indice]
    }
}