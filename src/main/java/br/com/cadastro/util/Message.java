package br.com.cadastro.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * A classe Message fornece métodos estáticos para exibir mensagens do tipo
 * informação , erro e aviso na interface do usuário, utilizando o FacesContext
 * do JSF. A classe Message facilita a exibição de mensagens para o usuário de
 * forma centralizada e consistente, melhorando a experiência do usuário em uma
 * aplicação web JSF.
 */
public class Message {

	public static void info(String info, String mesangem) {

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, info, mesangem);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static void erro(String erro, String mesangem) {

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, mesangem);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static void warr(String warr, String mesangem) {

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, warr, mesangem);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
