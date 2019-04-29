package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "dbPaises";
    private static final int VERSAO_BANCO = 1;
    public static final String TABELA_Paises = "paises_tabela";
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_NAME = "name";
    public static final String COLUNA_LATITUDE = "latitude";
    public static final String COLUNA_LONGITUDE = "longitude";
    public static final String COLUNA_ALPHA2CODE = "alpha2Code";
    public static final String COLUNA_ALPHA3CODE = "alpha3Code";
    public static final String COLUNA_CAPITAL = "capital";
    public static final String COLUNA_REGION = "region";
    public static final String COLUNA_SUBREGION = "subregion";
    public static final String COLUNA_POPULATION = "population";
    public static final String COLUNA_DEMONYM = "demonym";
    public static final String COLUNA_AREA = "area";
    public static final String COLUNA_GINI = "gini";
    public static final String COLUNA_NATIVENAME = "nativename";
    public static final String COLUNA_NUMERICCODE = "numericCode";




    public SQLHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABELA_Paises + " ( " +
                        COLUNA_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                        COLUNA_NAME + " TEXT, " +
                        COLUNA_LATITUDE + " TEXT, " +
                        COLUNA_LONGITUDE + " TEXT, " +
                        COLUNA_ALPHA2CODE + " TEXT, " +
                        COLUNA_ALPHA3CODE + " TEXT, " +
                        COLUNA_CAPITAL + " TEXT, " +
                        COLUNA_REGION + " TEXT, " +
                        COLUNA_SUBREGION + " TEXT, " +
                        COLUNA_POPULATION + " TEXT, " +
                        COLUNA_DEMONYM + " TEXT, " +
                        COLUNA_AREA + " TEXT, " +
                        COLUNA_GINI + " TEXT, " +
                        COLUNA_NATIVENAME + " TEXT, " +
                        COLUNA_NUMERICCODE + " TEXT)"
        );

    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // para as próximas versões
    }

}
