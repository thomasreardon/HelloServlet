package controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface Controller {
	void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException;
	void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
