package controller.commands;

import view.GlobalConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAssignationsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        return GlobalConstants.REST_SHOW_PATIENT_INFO + "?id=1"; // TODO
    }
}
