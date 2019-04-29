package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Model.Paises;

public class Repositorio {

    private SQLHelper helper;
    private SQLiteDatabase db;

    public Repositorio(Context ctx){
        helper = new SQLHelper(ctx);
    }

    public long inserir(Paises paises){
        db = helper.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SQLHelper.COLUNA_NAME, paises.name);
        cv.put(SQLHelper.COLUNA_LATITUDE, paises.latitude);
        cv.put(SQLHelper.COLUNA_LONGITUDE, paises.longitude);
        cv.put(SQLHelper.COLUNA_ALPHA2CODE, paises.alpha2Code);
        cv.put(SQLHelper.COLUNA_ALPHA3CODE, paises.alpha3Code);
        cv.put(SQLHelper.COLUNA_CAPITAL, paises.capital);
        cv.put(SQLHelper.COLUNA_REGION, paises.region);
        cv.put(SQLHelper.COLUNA_SUBREGION, paises.subregion);
        cv.put(SQLHelper.COLUNA_POPULATION, paises.population);
        cv.put(SQLHelper.COLUNA_DEMONYM, paises.demonym);
        cv.put(SQLHelper.COLUNA_AREA, paises.area);
        cv.put(SQLHelper.COLUNA_GINI, paises.gini);
        cv.put(SQLHelper.COLUNA_NATIVENAME, paises.nativename);
        cv.put(SQLHelper.COLUNA_NUMERICCODE, paises.numericCode);

        long id = db.insert(SQLHelper.TABELA_Paises, null, cv);

        if(id != -1){
            paises.id = id;
        }
        db.close();
        return id;
    }

    public void excluirAll(){
        db = helper.getWritableDatabase();
        db.delete(SQLHelper.TABELA_Paises, null, null);
        db.close();
    }

    public List<Paises> listarPaises() {
        String sql = "SELECT * FROM " + SQLHelper.TABELA_Paises;
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        List<Paises> list = new ArrayList();

        while (cursor.moveToNext()) {
            long id = cursor.getLong(
                    cursor.getColumnIndex(SQLHelper.COLUNA_ID)
            );
            String name = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_NAME)
            );
            String latitude = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_LATITUDE)
            );
            String longitude = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_LONGITUDE)
            );
            String alpha2Code = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_ALPHA2CODE)
            );
            String alpha3Code = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_ALPHA3CODE)
            );
            String capital = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_CAPITAL)
            );
            String region = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_REGION)
            );
            String subregion = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_SUBREGION)
            );
            String population = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_POPULATION)
            );
            String demonym = cursor.getString(
                    cursor.getColumnIndex(
                            SQLHelper.COLUNA_DEMONYM)
            );

            String area = cursor.getString(
                    cursor.getColumnIndex(
                            SQLHelper.COLUNA_AREA)
            );
            String gini = cursor.getString(
                    cursor.getColumnIndex(
                            SQLHelper.COLUNA_GINI)
            );
            String nativename = cursor.getString(
                    cursor.getColumnIndex(
                            SQLHelper.COLUNA_NATIVENAME)
            );
            String numericCode = cursor.getString(
                    cursor.getColumnIndex(
                            SQLHelper.COLUNA_NUMERICCODE)
            );

            Paises paises = new Paises(id, name, latitude, longitude,  alpha2Code, alpha3Code, capital, region, subregion, population,demonym,  area, gini, nativename, numericCode);
            list.add(paises);
        }
        cursor.close();
        return list;
    }
}
