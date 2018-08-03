package com.ericgibson.website.services;

import com.ericgibson.website.builders.Request;
import com.ericgibson.website.builders.Service;
import com.ericgibson.website.gateways.CloudStorageGateway;
import com.ericgibson.website.responders.PhotosIndexResponder;

import java.util.List;

public class PhotosIndexService extends Service {

    private final CloudStorageGateway gateway;
    private final PhotosIndexResponder responder;
    private final PhotosIndexResponse response = new PhotosIndexResponse();


    public PhotosIndexService(CloudStorageGateway gateway, PhotosIndexResponder responder) {
        this.gateway = gateway;
        this.responder = responder;
    }

    @Override
    public void execute(Request request) {
        PhotosIndexRequest photosIndexRequest = (PhotosIndexRequest) request;
        gateway.createStorage(photosIndexRequest.storage);
        List<String> keys = gateway.listObjectKeys(photosIndexRequest.storage);
        response.setKeys(keys);
        responder.present(response);
    }
}