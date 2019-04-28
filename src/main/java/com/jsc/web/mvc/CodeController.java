package com.jsc.web.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface CodeController {
    void getCheckCode(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
