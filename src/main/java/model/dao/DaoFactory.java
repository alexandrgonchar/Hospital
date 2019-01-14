package model.dao;

import controller.exception.AppException;
import view.Errors;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class DaoFactory {

    public abstract DaoConnection getConnection();

    public abstract StaffDao createStaffDao(DaoConnection connection);
    public abstract PatientDao createPatientDao(DaoConnection connection);
    public abstract DiagnosisHistoryDao createDiagnosisHistoryDao(DaoConnection connection);
    public abstract DiagnosisDao createDiagnosisDao(DaoConnection connection);
    public abstract AssignationsDrugsDao createAssignationsDrugsDao(DaoConnection connection);
    public abstract AssignationsProceduresDao createAssignationsProceduresDao(DaoConnection connection);
    public abstract AssignationsSurgeriesDao createAssignationsSurgeriesDao(DaoConnection connection);
    public abstract DrugDao createDrugDao(DaoConnection connection);
    public abstract ProcedureDao createProcedureDao(DaoConnection connection);
    public abstract SurgeryDao createSurgeryDao(DaoConnection connection);

    private static final String DB_FILE = "/db.properties";

    private static final String DB_FACTORY_CLASS = "factory.class";

    private static DaoFactory instance;

    public static DaoFactory getInstance() {
        if (instance == null) {
            try {
                InputStream inputStream = DaoFactory.class.getResourceAsStream(DB_FILE);
                Properties dbProps = new Properties();
                dbProps.load(inputStream);
                String factoryClass = dbProps.getProperty(DB_FACTORY_CLASS);
                instance = (DaoFactory) Class.forName(factoryClass).newInstance();
            } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                throw new AppException(Errors.DAO_FACTORY_EXCEPTION, e);
            }
        }
        return instance;
    }

}
