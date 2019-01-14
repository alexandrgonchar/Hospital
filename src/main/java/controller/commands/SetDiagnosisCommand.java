package controller.commands;

import model.entities.Diagnosis;
import model.entities.DiagnosisType;
import model.services.DiagnosisService;
import org.apache.log4j.Logger;
import view.Attributes;
import view.Parameters;
import view.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SetDiagnosisCommand extends CommandWrapper {

    private static final String TITLE_DIAGNOSIS_SET = "title.diagnosis.set";

    private DiagnosisService diagnosisService = DiagnosisService.getInstance();

    @Override
    public String doExecute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DiagnosisType diagnosisType = DiagnosisType.valueOf(request.getParameter(Parameters.DIAGNOSIS_TYPE));
        request.getSession().setAttribute(Parameters.DIAGNOSIS_TYPE, diagnosisType);

        List<Diagnosis> diagnosesList = diagnosisService.getAllDiagnoses();
        request.setAttribute(Attributes.DIAGNOSES_LIST, diagnosesList);

        request.setAttribute(Attributes.PAGE_TITLE, TITLE_DIAGNOSIS_SET);
        return Paths.DIAGNOSES_JSP;
    }

}
