package com.ericgibson.website.repositories;

import com.amazonaws.services.s3.AmazonS3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.ericgibson.website.TestingConstants.STORAGE;
import static com.ericgibson.website.TestingConstants.KEY;

public class AmazonClientFake extends AmazonClient {

    public boolean shouldCallListOfKeysMethod = false;
    public boolean shouldCallPutObjectMethod = false;
    public boolean shouldCallDeleteObjectMethod = false;

    public AmazonClientFake(AmazonS3 amazonS3) {
        super(amazonS3);
    }

    @Override
    public void createStorage(String storage) {
    }

    @Override
    public void putObject(String storage, String key, File file) {
        shouldCallPutObjectMethod =
                (storage.equals(STORAGE) && key.equals("8A570DFCFF2247286D6D172414662B1E") && file.getName().equals("IMG_FILE.jpg")) ||
                        (storage.equals(STORAGE) && key.equals("8A570DFCFF2247286D6D172414662B1Ethumbnail") && file.getName().equals("Thumbnail.png"));
    }

    @Override
    public List<String> listObjectKeys(String storage) {
        shouldCallListOfKeysMethod = storage.equals(STORAGE);
        List<String> keys = new ArrayList<>();
        keys.add(KEY);
        return keys;
    }

    @Override
    public void deleteObject(String storage, String key) {
        shouldCallDeleteObjectMethod = storage.equals(STORAGE) && key.equals(KEY) ||
                storage.equals(STORAGE) && key.equals(KEY + "thumbnail");
    }
}
