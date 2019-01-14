package controller.commands;

import controller.exception.AppException;
import org.apache.log4j.Logger;
import view.Attributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class CommandWrapper implements Command {

    private static final Object ERROR = "error";
    private static final Logger LOGGER = Logger.getLogger(CommandWrapper.class);

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            return doExecute(request, response);
        } catch (AppException e) {
            LOGGER.error(e);
            request.setAttribute(Attributes.PAGE_TITLE, ERROR);
            throw e;
        }
    }

    abstract String doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
