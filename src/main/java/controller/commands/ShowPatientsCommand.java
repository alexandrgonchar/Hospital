package controller.commands;

import model.entities.Patient;
import model.services.PatientService;
import view.Attributes;
import view.Parameters;
import view.Paths;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPatientsCommand extends CommandWrapper {

	private static final String TITLE_PATIENTS_SHOW = "title.patients.show";

	private PatientService patientService = PatientService.getInstance();

	@Override
	public String doExecute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        List<Patient> patients = patientService.getAllPatients();
        request.setAttribute(Parameters.ATTR_PATIENTS_LIST, patients);

        request.setAttribute(Attributes.PAGE_TITLE, TITLE_PATIENTS_SHOW);
		return Paths.PATIENTS_JSP;
	}

}
