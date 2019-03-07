package serendipity.web.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import util.libfunctions.QueryAnalyser;

@FacesValidator("queryValidator")
public class QueryValidator implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		String query = (String) value;
		if(!QueryAnalyser.isQueryValid(query)) {
			FacesMessage message = new FacesMessage("The submitted query is not valid.");
//			message.setSeverity(FacesMessage.SEVERITY_ERROR);
//			FacesContext.getCurrentInstance().addMessage("actionOption:fieldSearch", message);
//			
			throw new ValidatorException(message);
		}
	}

}
