package za.ac.cput.funeralapp.main.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import za.ac.cput.funeralapp.main.config.database.DBConstants;
import za.ac.cput.funeralapp.main.domain.Clients;
import za.ac.cput.funeralapp.main.repository.ClientsRepository;

/**
 * Created by Thabo on 4/24/2016.
 */
public class ClientsRepositoryImpl extends SQLiteOpenHelper implements ClientsRepository {
    public static final String TABLE_NAME = "clients";
    private SQLiteDatabase db;


    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_LASTNAME = "lastName";
    public static final String COLUMN_IDNUMBER = "idnumber";

    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_FIRSTNAME + " TEXT NOT NULL , "
            + COLUMN_LASTNAME + " TEXT NOT NULL , "
            + COLUMN_IDNUMBER + " TEXT NOT NULL);";

    public ClientsRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Clients findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_FIRSTNAME,
                        COLUMN_LASTNAME,
                        COLUMN_IDNUMBER},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Clients clients = new Clients.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .firstName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                    .lastName(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                    .idNumber(cursor.getString(cursor.getColumnIndex(COLUMN_IDNUMBER)))
                    .build();
            return clients;
        } else {
            return null;
        }
    }

    @Override
    public Clients save(Clients entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getID());
        values.put(COLUMN_FIRSTNAME, entity.getFirstName());
        values.put(COLUMN_LASTNAME, entity.getLastName());
        values.put(COLUMN_IDNUMBER, entity.getIDNumber());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Clients insertedEntity = new Clients.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Clients update(Clients entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getID());
        values.put(COLUMN_FIRSTNAME, entity.getFirstName());
        values.put(COLUMN_LASTNAME, entity.getLastName());
        values.put(COLUMN_IDNUMBER, entity.getIDNumber());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getID())}
        );
        return entity;
    }

    @Override
    public Clients delete(Clients entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getID())});
        return entity;
    }

    @Override
    public Set<Clients> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Clients> clients = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                final Clients client = new Clients.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .firstName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                        .lastName(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                        .idNumber(cursor.getString(cursor.getColumnIndex(COLUMN_IDNUMBER)))
                        .build();
                clients.add(client);
            } while (cursor.moveToNext());
        }
        return clients;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}


