package com.example.proejto_desafio.DAO

import android.content.Context
import com.example.proejto_desafio.bancoHelper.bancoHelper
import android.content.ContentValues
import com.example.proejto_desafio.modelo.Cor

class corDAO {

    private lateinit var banco: bancoHelper

    constructor(context: Context){
        this.banco = bancoHelper(context)
    }

    fun insert(cor: Cor){
        val cv = ContentValues()
        cv.put("nome", cor.nome)
        cv.put("codigo", cor.codigo)
        this.banco.writableDatabase.insert("cores",null,cv)

    }

    fun update(cor: Cor){
        val where = "id = ?"
        val pWhere = arrayOf(cor.id.toString())
        val cv = ContentValues()
        cv.put("nome", cor.nome)
        cv.put("codigo", cor.codigo)
        this.banco.writableDatabase.update("cores", cv,where,pWhere)
    }

    fun delete(id: Int){
        val where = "id = ?"
        val pwhere = arrayOf(id.toString())
        this.banco.writableDatabase.delete("cores", where,pwhere)
    }

    fun count(): Int{
        val sql = "SELECT COUNT(*) FROM CORES"
        val cursor = this.banco.readableDatabase.rawQuery(sql, null)
        cursor.moveToFirst()
        return  cursor.getInt(0)
    }

    fun select(): ArrayList<Cor>{
        val listaDeCores = ArrayList<Cor>()
        val colunas = arrayOf("id", "nome", "codigo")

        val cursor = this.banco.readableDatabase.query("cores", colunas, null, null, null, null, "nome")
        cursor.moveToFirst()

        for (i in 1..cursor.count){
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val nome = cursor.getString(cursor.getColumnIndex("nome"))
            val codigo = cursor.getInt(cursor.getColumnIndex("codigo"))

            listaDeCores.add(Cor(id,nome,codigo))
            cursor.moveToNext()
        }

        return listaDeCores
    }

    fun find(id: Int): Cor?{
        val colunas = arrayOf("id", "nome", "codigo")
        val where = "id = ?"
        val pwhere = arrayOf(id.toString())

        val cursor = this.banco.readableDatabase.query("cores", colunas, null, null, null, null, "nome")
        cursor.moveToFirst()

        if(cursor.count == 1){
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val nome = cursor.getString(cursor.getColumnIndex("nome"))
            val codigo = cursor.getInt(cursor.getColumnIndex("codigo"))

            return Cor(id, nome, codigo)
        }

        return null
    }
}