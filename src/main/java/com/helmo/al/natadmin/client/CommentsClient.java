/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.client;

import com.helmo.al.natadmin.entity.Comment;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author foers
 */
public class CommentsClient extends BaseClient<Comment> {
    
    public CommentsClient() {
        super(Comment.class, new GenericType<List<Comment>>(){}, "comments");
    }

    @Override
    public List<Comment> getAll() {
        return super.getAll();
    }

    @Override
    public Comment get(String id) throws ClientErrorException {
        return super.get(id);
    }
    
    public List<Comment> getAllReported() {
        return super.getAllFromCustomPath("/reported");
    }
    
    public Comment getReportedById(String id) {
        return super.getCustomFromId(id, "/reported/" + id);
    }
}
