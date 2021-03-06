package com.hadithbd.banglahadith.ui;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.hadithbd.banglahadith.R;
import com.hadithbd.banglahadith.database.CsvToDbHelper;
import com.hadithbd.banglahadith.database.DbHelper;
import com.hadithbd.banglahadith.database.DbManager;
import com.hadithbd.banglahadith.viewmodel.HadithMainInfo;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    private RelativeLayout mLayoutAllHadiths;

    private RelativeLayout mLayoutAllBooks;

    private DbHelper mDbHelper;

    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // setHomeBackgroundLayer();

        DbManager.init(this);
        mDbHelper = new DbHelper(getApplicationContext());
        mDatabase = mDbHelper.getWritableDatabase();

        mDatabase.beginTransaction();
        try {
            Log.e("Insertion", "Start");
            CsvToDbHelper.sBulkInsert(this, R.raw.bookwriter, mDatabase);
            CsvToDbHelper.sBulkInsert(this, R.raw.booktype, mDatabase);
            CsvToDbHelper.sBulkInsert(this, R.raw.bookname, mDatabase);
            CsvToDbHelper.sBulkInsert(this, R.raw.booksection, mDatabase);

            CsvToDbHelper.sBulkInsert(this, R.raw.rabihadith, mDatabase);
            CsvToDbHelper.sBulkInsert(this, R.raw.hadithstatus, mDatabase);
            CsvToDbHelper.sBulkInsert(this, R.raw.hadithpublisher, mDatabase);
            CsvToDbHelper.sBulkInsert(this, R.raw.hadithsection, mDatabase);
            CsvToDbHelper.sBulkInsert(this, R.raw.hadithchapter, mDatabase);
            CsvToDbHelper.sBulkInsert(this, R.raw.hadithbook, mDatabase);

            CsvToDbHelper.sBulkInsert(this, R.raw.bookcontent, mDatabase);
            CsvToDbHelper.sBulkInsert(this, R.raw.hadithmain, mDatabase);
            CsvToDbHelper.sBulkInsert(this, R.raw.hadithexplanation, mDatabase);



            mDatabase.setTransactionSuccessful();
            Log.e("Insertion", "End");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mDatabase.endTransaction();
        }

/*        List<Integer> idList = DbManager.getInstance().getHadithNoListForSection(166);
        for (Integer i : idList) {
            Log.e("Hadith Id", "" + i);
        }
        HadithMainInfo info = DbManager.getInstance().getHadithInformationForHadith(idList.get(0));
        Log.e("called","");*/

        /*BookContentInfo info = DbManager.getInstance().getBookContentInfo(108);
        Log.e("Content Info ", info.getBookName() + " _ " + info.getSectionName() + " _ " + info.getQuestion() + " _ " + info.getAnswer() + " _ " + info.getBookName() + " _ ");
        List<BookInfo> list = DbManager.getInstance().getAllBookInfoForType(7);
        for (BookInfo book : list) {
            Log.e("Chapter info ", book.getBookId() + " _ " + book.getBookName() + " _ " + book.getQuestionCount());
        }


        List<BookTypeInfo> list = DbManager.getInstance().getAllBookTypeInfo();
        for (BookTypeInfo book : list) {
            Log.e("Chapter info ", book.getTypeId() + " _ " + book.getCategoryNae() + " _ " + book.getBookCount());
        }

        List<HadithBookChapterInfo> list = DbManager.getInstance().getHadithBookSectionInfo(1);
        for (HadithBookChapterInfo book : list) {
            Log.e("Chapter info ", book.getChapterId() + " _ " + book.getSectionName() + " _ " + book.getHadithCount());
        }

        List<HadithBookInfo> list = DbManager.getInstance().getAllHadithBookInfo();
        for(HadithBookInfo book : list){
            Log.e("Book Name : ", book.getBookName());
            Log.e("Chapter : ", ""+book.getSectionCount());
            Log.e("Hadith : ", ""+book.getHadithCount());
        }
        List<Integer> idList = DbManager.getInstance().getHadithNoListForSection(162);
        HadithMainInfo info = DbManager.getInstance().getHadithInformationForHadith(idList.get(0));*/


       /* List<BookType> list = DbManager.getInstance().getAllBookTypes();
        Log.e("Size", ""+list.size());
        for(BookType t : list){
            Log.e("Type Name : ", t.getCategoryName());
        }

        List<BookWriter> writers = DbManager.getInstance().getAllBookWriters();
        Log.e("Size", ""+writers.size());
        for(BookWriter writer : writers){
            Log.e("Writer Name : ", writer.getNameEnglish());
        }

        List<BookName> names = DbManager.getInstance().getAllBookNames();
        Log.e("Size", ""+names.size());
        for(BookName name : names){
            Log.e("Book Name : ", name.getNameBengali());
        }

        List<BookContent> contents = DbManager.getInstance().getAllBookContents();
        Log.e("Size", ""+contents.size());
        for(BookContent content : contents){
            Log.e("Content Name : ", content.getQuestion());
        }

        List<BookSection> sections = DbManager.getInstance().getAllBookSections();
        Log.e("Size", ""+sections.size());
        for(BookSection section : sections){
            Log.e("Section Name : ", section.getName());
        }

        List<RabiHadith> rabiHadiths = DbManager.getInstance().getAllRabiHadiths();
        Log.e("Rabi Hadith", ""+rabiHadiths.size());
        for(RabiHadith rabiHadith : rabiHadiths){
            Log.e("Rabi Name : ", rabiHadith.getRabiBengali());
        }

        List<HadithStatus> hadithStatuses = DbManager.getInstance().getAllHadithStatus();
        Log.e("Hadith Status Size", ""+hadithStatuses.size());
        for(HadithStatus hadithStatus : hadithStatuses){
            Log.e("Hadith Status Name : ", hadithStatus.getStatusBengali());
        }

        List<HadithPublisher> publishers = DbManager.getInstance().getAllHadithPublishers();
        Log.e("Hadith Publisher Size", ""+publishers.size());
        for(HadithPublisher publisher : publishers){
            Log.e("Hadith Publisher Name : ", publisher.getNameBengali());
        }

        List<HadithSection> sections = DbManager.getInstance().getAllHadithSections();
        Log.e("Hadith Section Size", ""+sections.size());
        for(HadithSection section : sections){
            Log.e("Hadith Section Name : ", section.getNameBengali());
        }

        List<HadithExplanation> explanations = DbManager.getInstance().getAllHadithExplanations();
        Log.e("Hadith Explanation Size", ""+explanations.size());
        for(HadithExplanation explanation : explanations){
            Log.e("Hadith Explanation : ", explanation.getExplanation());
        }

        List<HadithChapter> chapters = DbManager.getInstance().getAllHadithChapters();
        Log.e("Hadith Chapter Size", ""+chapters.size());
        for(HadithChapter chapter : chapters){
            Log.e("Hadith Chapter : ", chapter.getNameBengali());
        }

        List<HadithBook> books = DbManager.getInstance().getAllHadithBooks();
        Log.e("Hadith Book Size", ""+books.size());
        for(HadithBook book : books){
            Log.e("Hadith Book : ", book.getNameBengali());
        }

        List<HadithMain> mains = DbManager.getInstance().getAllHadithMains();
        Log.e("Hadith Main Size", "" + mains.size());
        for(HadithMain main : mains) {
            Log.e("Hadith Main : ", main.getHadithBengali());
        }*/
        initLayouts();

        mLayoutAllHadiths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), HadithListActivity.class));
            }
        });

        mLayoutAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), BookCategoryListActivity.class));
            }
        });

    }

    private void initLayouts() {
        mLayoutAllHadiths = (RelativeLayout) findViewById(R.id.layout_all_hadiths);
        mLayoutAllBooks = (RelativeLayout) findViewById(R.id.layout_all_books);
    }
}
