package com.example.quizbandeiras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
//Classe onde criamos o banco de dados do ranking
public class BancoDados extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Ranking.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "lista_ranking";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NOME = "nome_usuario";
    private static final String COLUMN_PONTOS = "pontos_usuario";

    public BancoDados(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NOME + " TEXT, " + COLUMN_PONTOS  + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    //Adciona um usuario ao banco de dados
    void addPlayerRanking(String nome, int pontos){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NOME, nome);
        cv.put(COLUMN_PONTOS, pontos);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Falhou", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Adicionado com Sucesso", Toast.LENGTH_SHORT).show();
        }
    }

    //Retorna a cursor(Contem toda a tabela)
    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COLUMN_PONTOS + " DESC";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
