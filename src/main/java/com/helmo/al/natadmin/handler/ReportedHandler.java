/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.handler;

import com.helmo.al.natadmin.client.CommentsClient;
import com.helmo.al.natadmin.entity.Comment;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author foers
 */

@ManagedBean
@RequestScoped
public class ReportedHandler extends BaseHandler<Comment> {
    
    public ReportedHandler() {
        super(Comment.class, new CommentsClient());
    }
    
    public String countReported() {
        return ((CommentsClient) client).countReported();
    }
    
    public List<Comment> allReported() {
        return ((CommentsClient) client).allReported();
    }
}
