package com.example.greendaomigration;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationGreendaoMigration extends Application {

    private static DaoSession iponChallengeSession;

    @Override
    public void onCreate() {
        super.onCreate();

        File parentFile = this.getDir("databases", Context.MODE_PRIVATE);
        if (!parentFile.exists())
            parentFile.mkdirs();

        String parentPath = parentFile.getAbsolutePath();
        File iponChallengePath = new File(parentPath + "iponChallenge.db");
        createDatabases(iponChallengePath);

        iponChallengeSession = new DaoMaster(new OpenHelper(this, iponChallengePath.getAbsolutePath(),null).getWritableDatabase()).newSession();
    }

    public static MDL_IponChallengeDao getIponChallengeSession(){
        return iponChallengeSession.getMDL_IponChallengeDao();
    }

    private void createDatabases(File path){

        if(!path.exists()) {
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(path);
                out.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static ArrayList<MDL_IponChallenge> getIponChallenges (){
        List<MDL_IponChallenge> piggyBanksList = ApplicationGreendaoMigration.getIponChallengeSession()
                .queryBuilder()
                .list();

        return (ArrayList<MDL_IponChallenge>) piggyBanksList;
    }
}
