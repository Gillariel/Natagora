/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.servlet;

/**
 *
 * @author foers
 */

import com.helmo.al.natadmin.client.BirdsClient;
import com.helmo.al.natadmin.entity.Bird;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BirdsServlet", urlPatterns = {"/birds"})
public class BirdsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        List<Bird> birds = new BirdsClient().findAlll();

        request.setAttribute("birds", birds);
        request.getRequestDispatcher("/faces/birds.xhtml").forward(request, response);
    }
}