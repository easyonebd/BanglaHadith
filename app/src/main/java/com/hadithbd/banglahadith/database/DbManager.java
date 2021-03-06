package com.hadithbd.banglahadith.database;

import android.content.Context;

import com.hadithbd.banglahadith.database.tables.book.BookContent;
import com.hadithbd.banglahadith.database.tables.book.BookName;
import com.hadithbd.banglahadith.database.tables.book.BookSection;
import com.hadithbd.banglahadith.database.tables.book.BookType;
import com.hadithbd.banglahadith.database.tables.book.BookWriter;
import com.hadithbd.banglahadith.database.tables.hadith.HadithBook;
import com.hadithbd.banglahadith.database.tables.hadith.HadithChapter;
import com.hadithbd.banglahadith.database.tables.hadith.HadithExplanation;
import com.hadithbd.banglahadith.database.tables.hadith.HadithMain;
import com.hadithbd.banglahadith.database.tables.hadith.HadithPublisher;
import com.hadithbd.banglahadith.database.tables.hadith.HadithSection;
import com.hadithbd.banglahadith.database.tables.hadith.HadithStatus;
import com.hadithbd.banglahadith.database.tables.hadith.RabiHadith;
import com.hadithbd.banglahadith.viewmodel.BookContentInfo;
import com.hadithbd.banglahadith.viewmodel.BookContentTitleInfo;
import com.hadithbd.banglahadith.viewmodel.BookInfo;
import com.hadithbd.banglahadith.viewmodel.BookTypeInfo;
import com.hadithbd.banglahadith.viewmodel.HadithBookInfo;
import com.hadithbd.banglahadith.viewmodel.HadithBookSectionInfo;
import com.hadithbd.banglahadith.viewmodel.HadithMainInfo;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rayhan on 02/24/2015.
 */
public class DbManager {
    static private DbManager instance;
    private DbHelper helper;

    private DbManager(Context ctx) {
        helper = new DbHelper(ctx);
    }

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new DbManager(ctx);
        }
    }

    static public DbManager getInstance() {
        return instance;
    }

    private DbHelper getHelper() {
        return helper;
    }

    public List<BookWriter> getAllBookWriters() {
        List<BookWriter> bookWriterList = new ArrayList<>();
        try {
            bookWriterList = getHelper().getBookWriterDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookWriterList;
    }

    public List<BookType> getAllBookTypes() {
        List<BookType> bookTypeList = new ArrayList<>();
        try {
            bookTypeList = getHelper().getBookTypeDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookTypeList;
    }

    public List<BookName> getAllBookNames() {
        List<BookName> bookNameList = new ArrayList<>();
        try {
            bookNameList = getHelper().getBookNameDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookNameList;
    }

    public List<BookContent> getAllBookContents() {
        List<BookContent> bookContentList = new ArrayList<>();
        try {
            bookContentList = getHelper().getBookContentDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookContentList;
    }

    public List<BookSection> getAllBookSections() {
        List<BookSection> bookSectionList = new ArrayList<>();
        try {
            bookSectionList = getHelper().getBookSectionDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookSectionList;
    }

    public List<RabiHadith> getAllRabiHadiths() {
        List<RabiHadith> rabiHadithList = new ArrayList<>();
        try {
            rabiHadithList = getHelper().getRabiHadithDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rabiHadithList;
    }

    public List<HadithStatus> getAllHadithStatus() {
        List<HadithStatus> hadithStatusList = new ArrayList<>();
        try {
            hadithStatusList = getHelper().getHadithStatusDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hadithStatusList;
    }

    public List<HadithSection> getAllHadithSections() {
        List<HadithSection> hadithSectionList = new ArrayList<>();
        try {
            hadithSectionList = getHelper().getHadithSectionDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hadithSectionList;
    }

    public List<HadithPublisher> getAllHadithPublishers() {
        List<HadithPublisher> hadithPublisherList = new ArrayList<>();
        try {
            hadithPublisherList = getHelper().getHadithPublisherDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hadithPublisherList;
    }

    public List<HadithMain> getAllHadithMains() {
        List<HadithMain> hadithMainList = new ArrayList<>();
        try {
            hadithMainList = getHelper().getHadithMainDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hadithMainList;
    }


    public List<HadithExplanation> getAllHadithExplanations() {
        List<HadithExplanation> hadithExplanationList = new ArrayList<>();
        try {
            hadithExplanationList = getHelper().getHadithExplanationDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hadithExplanationList;
    }

    public List<HadithChapter> getAllHadithChapters() {
        List<HadithChapter> hadithChapterList = new ArrayList<>();
        try {
            hadithChapterList = getHelper().getHadithChapterDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hadithChapterList;
    }

    public List<HadithBook> getAllHadithBooks() {
        List<HadithBook> hadithBookList = new ArrayList<>();
        try {
            hadithBookList = getHelper().getHadithBookDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hadithBookList;
    }

    public HadithBook getHadithBook(int hadithBookId) {
        HadithBook entity = new HadithBook();
        QueryBuilder<HadithBook, Integer> qb = getHelper().getHadithBookDao().queryBuilder();
        Where<HadithBook, Integer> where = qb.where();
        try {
            where.eq("id", hadithBookId);
            entity = where.query().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public List<HadithSection> getHadithSectionsForBook(int bookId) {
        List<HadithSection> sectionList = new ArrayList<>();
        QueryBuilder<HadithSection, Integer> qb = getHelper().getHadithSectionDao().queryBuilder();
        Where<HadithSection, Integer> where = qb.where();
        try {
            where.eq("bookId", bookId);
            sectionList = where.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sectionList;
    }

    public List<HadithBookSectionInfo> getHadithBookSectionInfo(int bookId) {
        List<HadithSection> sectionList = getHadithSectionsForBook(bookId);
        List<HadithBookSectionInfo> hadithBookSectionInfoList = new ArrayList<>();

        for (HadithSection section : sectionList) {
            long hadithCount = 0;
            QueryBuilder<HadithMain, Integer> hadithMainQueryBuilder = getHelper().getHadithMainDao().queryBuilder();
            Where<HadithMain, Integer> whereHadithMain = hadithMainQueryBuilder.where();

            try {
                hadithCount = whereHadithMain.eq("sectionId", section.getId()).countOf();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            hadithBookSectionInfoList.add(new HadithBookSectionInfo(section.getId(), section.getNameBengali(), hadithCount));
        }

        return hadithBookSectionInfoList;
    }

    public long getHadithCount() {
        try {
            return getHelper().getHadithMainDao().countOf();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<HadithBookInfo> getAllHadithBookInfo() {
        List<HadithBook> hadithBookList = getAllHadithBooks();
        List<HadithBookInfo> hadithBookInfoList = new ArrayList<>();

        for (HadithBook hadithBook : hadithBookList) {
            long sectionCount = 0, hadithCount = 0;
            QueryBuilder<HadithSection, Integer> qb = getHelper().getHadithSectionDao().queryBuilder();
            Where<HadithSection, Integer> where = qb.where();

            QueryBuilder<HadithMain, Integer> hadithainQueryBuilder = getHelper().getHadithMainDao().queryBuilder();
            Where<HadithMain, Integer> whereHadithMain = hadithainQueryBuilder.where();

            try {
                sectionCount = where.eq("bookId", hadithBook.getId()).countOf();
                hadithCount = whereHadithMain.eq("bookId", hadithBook.getId()).countOf();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            hadithBookInfoList.add(new HadithBookInfo(hadithBook.getId(), hadithBook.getNameBengali(), sectionCount, hadithCount));
        }

        return hadithBookInfoList;
    }

    public List<Integer> getHadithNoListForSection(int sectionId) {
        List<HadithMain> mainList = new ArrayList<>();
        QueryBuilder<HadithMain, Integer> hadithMainQueryBuilder = getHelper().getHadithMainDao().queryBuilder();
        Where<HadithMain, Integer> whereHadithMain = hadithMainQueryBuilder.where();
        try {
            whereHadithMain.eq("sectionId", sectionId);
            mainList = whereHadithMain.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Integer> hadithIdList = new ArrayList<>();
        for (HadithMain main : mainList) {
            hadithIdList.add(main.getHadithNo());
        }
        return hadithIdList;
    }

    public HadithMain getHadithMainWithHadithNo(int hadithNo) {
        List<HadithMain> entity = new ArrayList<>();
        QueryBuilder<HadithMain, Integer> hadithMainQueryBuilder = getHelper().getHadithMainDao().queryBuilder();
        Where<HadithMain, Integer> whereHadithMain = hadithMainQueryBuilder.where();
        try {
            whereHadithMain.eq("hadithNo", hadithNo);
            entity = whereHadithMain.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (entity == null || entity.size() == 0)
            return null;
        return entity.get(0);
    }

    public String getRabiBengali(int rabiId) {
        List<RabiHadith> entity = new ArrayList<>();
        QueryBuilder<RabiHadith, Integer> qb = getHelper().getRabiHadithDao().queryBuilder();
        Where<RabiHadith, Integer> where = qb.where();
        try {
            where.eq("id", rabiId);
            entity = where.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (entity == null || entity.size() == 0)
            return "";
        return entity.get(0).getRabiBengali();
    }

    public String getHadithBookName(int hadithBookId) {
        List<HadithBook> entity = new ArrayList<>();
        QueryBuilder<HadithBook, Integer> qb = getHelper().getHadithBookDao().queryBuilder();
        Where<HadithBook, Integer> where = qb.where();
        try {
            where.eq("id", hadithBookId);
            entity = where.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (entity == null || entity.size() == 0)
            return "";
        return entity.get(0).getNameBengali();
    }

    public String getHadithSectionBengali(int sectionId) {
        List<HadithSection> entity = new ArrayList<>();
        QueryBuilder<HadithSection, Integer> qb = getHelper().getHadithSectionDao().queryBuilder();
        Where<HadithSection, Integer> where = qb.where();
        try {
            where.eq("id", sectionId);
            entity = where.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (entity == null || entity.size() == 0)
            return "";
        return entity.get(0).getNameBengali();
    }

    public HadithChapter getHadithChapter(int chapterId) {
        List<HadithChapter> entity = new ArrayList<>();
        QueryBuilder<HadithChapter, Integer> qb = getHelper().getHadithChapterDao().queryBuilder();
        Where<HadithChapter, Integer> where = qb.where();
        try {
            where.eq("id", chapterId);
            entity = where.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (entity == null || entity.size() == 0)
            return null;
        return entity.get(0);
    }

    public String getHadithStatusBengali(int statusId) {
        List<HadithStatus> entity = new ArrayList<>();
        QueryBuilder<HadithStatus, Integer> qb = getHelper().getHadithStatusDao().queryBuilder();
        Where<HadithStatus, Integer> where = qb.where();
        try {
            where.eq("id", statusId);
            entity = where.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (entity == null || entity.size() == 0)
            return "";
        return entity.get(0).getStatusBengali();
    }

    public String getHadithExplanation(int hadithId) {
        List<HadithExplanation> explanations = new ArrayList<>();
        QueryBuilder<HadithExplanation, Integer> qb = getHelper().getHadithExplanationDao().queryBuilder();
        Where<HadithExplanation, Integer> where = qb.where();
        try {
            where.eq("hadithId", hadithId);
            explanations = where.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (explanations == null || explanations.size() == 0)
            return "";
        return explanations.get(0).getExplanation();
    }

    public HadithMainInfo getHadithInformationForHadith(int hadithNo) {
        HadithMain main = getHadithMainWithHadithNo(hadithNo);

        HadithMainInfo mainInfo = new HadithMainInfo();
        mainInfo.setId(main.getId());
        mainInfo.setRabiId(main.getRabiId());
        mainInfo.setRabiBengali(getRabiBengali(main.getRabiId()));
        mainInfo.setBookId(main.getBookId());
        mainInfo.setBookName(getHadithBookName(main.getBookId()));
        mainInfo.setSectionId(main.getSectionId());
        mainInfo.setSectionBengali(getHadithSectionBengali(main.getSectionId()));
        mainInfo.setChapterId(main.getChapterId());
        if (getHadithChapter(main.getChapterId()) != null) {
            mainInfo.setChapterArabic(getHadithChapter(main.getChapterId()).getNameArabic());
            mainInfo.setChapterBengali(getHadithChapter(main.getChapterId()).getNameBengali());
        }
        mainInfo.setStatusId(main.getStatusId());
        mainInfo.setStatusBengali(getHadithStatusBengali(main.getStatusId()));
        mainInfo.setHadithNo(main.getHadithNo());
        mainInfo.setHadithArabic(main.getHadithArabic());
        mainInfo.setHadithBengali(main.getHadithBengali());
        mainInfo.setHadithEnglish(main.getHadithEnglish());
        mainInfo.setHadithExplanation(getHadithExplanation(main.getId()));
        mainInfo.setNote(main.getNote());
        mainInfo.setCheckStatus(main.getCheckStatus());

        return mainInfo;
    }

    public List<BookTypeInfo> getAllBookTypeInfo() {
        List<BookType> bookTypeList = getAllBookTypes();
        List<BookTypeInfo> bookTypeInfoList = new ArrayList<>();

        for (BookType bookType : bookTypeList) {
            long bookCount = 0;
            QueryBuilder<BookName, Integer> bookNameQueryBuilder = getHelper().getBookNameDao().queryBuilder();
            Where<BookName, Integer> whereBookName = bookNameQueryBuilder.where();

            try {
                bookCount = whereBookName.eq("typeId", bookType.getId()).countOf();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            bookTypeInfoList.add(new BookTypeInfo(bookType.getId(), bookType.getCategoryName(), bookCount));
        }

        return bookTypeInfoList;
    }

    public List<BookName> getAllBookNamesForTypeId(int typeId) {
        List<BookName> mainList = new ArrayList<>();
        QueryBuilder<BookName, Integer> qb = getHelper().getBookNameDao().queryBuilder();
        Where<BookName, Integer> where = qb.where();
        try {
            where.eq("typeId", typeId);
            mainList = where.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mainList;
    }

    public List<BookInfo> getAllBookInfoForType(int typeId) {
        List<BookName> bookList = getAllBookNamesForTypeId(typeId);
        List<BookInfo> bookInfoList = new ArrayList<>();

        for (BookName book : bookList) {
            long questionCount = 0;
            QueryBuilder<BookContent, Integer> qb = getHelper().getBookContentDao().queryBuilder();
            Where<BookContent, Integer> where = qb.where();

            try {
                questionCount = where.eq("bookId", book.getId()).countOf();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            bookInfoList.add(new BookInfo(book.getId(), book.getNameBengali(), questionCount));
        }

        return bookInfoList;
    }

    public List<BookContentTitleInfo> getContentTitleInfoForBook(int bookId) {
        List<BookContent> contentList = new ArrayList<>();
        List<BookContentTitleInfo> contentInfoList = new ArrayList<>();
        QueryBuilder<BookContent, Integer> qb = getHelper().getBookContentDao().queryBuilder();
        Where<BookContent, Integer> where = qb.where();
        try {
            where.eq("bookId", bookId);
            contentList = where.query();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (BookContent content : contentList) {
            contentInfoList.add(new BookContentTitleInfo(content.getId(), content.getQuestion()));
        }
        return contentInfoList;
    }

    public BookContent getBookContentWithId(int contentId) {
        BookContent bookContent = new BookContent();
        QueryBuilder<BookContent, Integer> qb = getHelper().getBookContentDao().queryBuilder();
        Where<BookContent, Integer> where = qb.where();
        try {
            where.eq("id", contentId);
            bookContent = where.query().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookContent;
    }

    public String getBookNameWithId(int bookId) {
        BookName entity = new BookName();
        QueryBuilder<BookName, Integer> qb = getHelper().getBookNameDao().queryBuilder();
        Where<BookName, Integer> where = qb.where();
        try {
            where.eq("id", bookId);
            entity = where.query().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity.getNameBengali();
    }

    public String getBookSectionNameWithId(int sectionId) {
        BookSection entity = new BookSection();
        QueryBuilder<BookSection, Integer> qb = getHelper().getBookSectionDao().queryBuilder();
        Where<BookSection, Integer> where = qb.where();
        try {
            where.eq("id", sectionId);
            entity = where.query().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity.getName();
    }

    public BookContentInfo getBookContentInfo(int contentId) {
        BookContent content = getBookContentWithId(contentId);
        BookContentInfo contentInfo = new BookContentInfo();

        contentInfo.setId(content.getId());
        contentInfo.setBookId(content.getBookId());
        contentInfo.setBookName(getBookNameWithId(content.getBookId()));
        contentInfo.setSectionId(content.getSectionId());
        contentInfo.setSectionName(getBookSectionNameWithId(content.getSectionId()));
        contentInfo.setQuestion(content.getQuestion());
        contentInfo.setAnswer(content.getAnswer());
        contentInfo.setNote(content.getNote());

        return contentInfo;
    }

}


