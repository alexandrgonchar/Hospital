package controller.commands;

import model.entities.Procedure;
import model.services.ProcedureService;
import view.Attributes;
import view.Parameters;
import view.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAddAssignationsProceduresFormCommand extends CommandWrapper {

    private static final String TITLE_ASSIGNATIONS_PROCEDURES_ADD_FORM = "title.assignations.procedures.add.form";

    private ProcedureService procedureService = ProcedureService.getInstance();

    @Override
    public String doExecute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int diagnosisHistoryId = Integer.parseInt(request.getParameter(Parameters.DIAGNOSIS_HISTORY_ID));

        List<Procedure> proceduresList = procedureService.getAllProcedures();
        request.setAttribute(Attributes.PROCEDURES_LIST, proceduresList);

        request.setAttribute(Attributes.DIAGNOSIS_HISTORY_ID, diagnosisHistoryId);
        request.setAttribute(Attributes.PAGE_TITLE, TITLE_ASSIGNATIONS_PROCEDURES_ADD_FORM);
        return Paths.ADD_ASSIGNATIONS_PROCEDURES_JSP;
    }

}
