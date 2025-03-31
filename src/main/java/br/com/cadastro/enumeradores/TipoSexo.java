package br.com.cadastro.enumeradores;

/**
 * O uso de enum permite a definição de valores fixos para o tipo de sexo e ajuda
 * a garantir que apenas valores válidos sejam atribuídos ao campo sexo.
 * O método getSexoComboBox()facilita a integração do enum com componentes de
 * interface, como dropdowns ou comboboxes. A classe TipoSexoé um enum (tipo
 * enumerado) que representa os dois valores possíveis de sexo:
 */
public enum TipoSexo {

	MASCULINO("Masculino"), FEMININO("Feminino");

	private TipoSexo(String sexo) {
		this.setsexo(sexo);
	}

	private String sexo;

	public static String[] getSexoComboBox() {
		String[] listaRetorno = new String[2];
		int i = 0;
		for (TipoSexo tipoSexo : TipoSexo.values()) {
			listaRetorno[i] = tipoSexo.getSexo();
			i++;
		}
		return listaRetorno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setsexo(String sexo) {
		this.sexo = sexo;
	}

}