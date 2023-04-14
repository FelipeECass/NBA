import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
class Jogador {
	
	private int m_id;
	private String m_nome;
	private int m_altura;
	private int m_peso;
	private String m_univ;
	private int m_anoNasc;
	private String m_cidadeNasc;
	private String m_estadoNasc;
	
	public Jogador(String p_id, String m_nome, String p_altura, String p_peso, String p_univ, String p_anoNasc)
	{
		this.m_id = Integer.parseInt(p_id);
		this.m_nome = m_nome;
		this.m_altura = Integer.parseInt(p_altura);
		this.m_peso = Integer.parseInt(p_peso);
		this.m_univ = p_univ;
		this.m_anoNasc = Integer.parseInt(p_anoNasc);
	}
	
	public Jogador(String p_id, String m_nome, String p_altura, String p_peso, String p_univ, String p_anoNasc, String p_cidadeNasc, String p_estadoNasc)
	{
		this.m_id = Integer.parseInt(p_id);
		this.m_nome = m_nome;
		this.m_altura = Integer.parseInt(p_altura);
		this.m_peso = Integer.parseInt(p_peso);
		this.m_univ = p_univ;
		this.m_anoNasc = Integer.parseInt(p_anoNasc);
		this.m_cidadeNasc = p_cidadeNasc;
		this.m_estadoNasc = p_estadoNasc;
	}
	
	public String Imprimir() {
		return "[" + Integer.toString(m_id) + " ## " 
				+ (m_nome != null ? m_nome : "nao informado")  + " ## " 
				+ (Integer.toString(m_altura) != null ? Integer.toString(m_altura) : "nao informado")  + " ## " 
				+ (Integer.toString(m_peso) != null ? Integer.toString(m_peso) : "nao informado")   + " ## "
				+ (Integer.toString(m_anoNasc) != null ? Integer.toString(m_anoNasc) : "nao informado")  + " ## "
				+ (m_univ != null ? m_univ : "nao informado") + " ## " 
				+ (m_cidadeNasc != null ? m_cidadeNasc : "nao informado")  + " ## "
				+ (m_estadoNasc != null ? m_estadoNasc : "nao informado") + "]";
	}
	
	public int getId() {
		return this.m_id;
	}
	public String getNome() {
		return this.m_nome;
	}
	public int getAltura() {
		return this.m_altura;
	}
	public int getPeso() {
		return this.m_peso;
	}
	public String getUniversidade() {
		return this.m_univ;
	}
	public int getAnoNascimento() {
		return this.m_anoNasc;
	}
	public String getCidadeNascimento() {
		return this.m_cidadeNasc;
	}
	public String getEstadoNascimento() {
		return this.m_estadoNasc;
	}
	
	public void setId(int p_id) {
		m_id = p_id;
	}
	public void setNome(String p_nome) {
		m_nome = p_nome;
	}
	public void setAltura(int p_altura) {
		m_altura = p_altura;
	}
	public void setPeso(int p_peso) {
		m_peso = p_peso;
	}
	public void setUniversidade(String p_univ) {
		m_univ = p_univ;
	}
	public void setAnoNascimento(int p_anoNasc) {
		m_anoNasc = p_anoNasc;
	}
	public void setCidadeNascimento(String p_cidadeNasc) {
		m_cidadeNasc = p_cidadeNasc;
	}
	public void setEstadoNascimento(String p_estadoNasc) {
		m_estadoNasc = p_estadoNasc;
	}
	
	public Jogador cloneObj(int p_id)
	{
		return new Jogador(String.valueOf(m_id),m_nome,String.valueOf(m_altura),String.valueOf(m_peso),m_univ,String.valueOf(m_anoNasc),m_cidadeNasc,m_estadoNasc);				
	}
}

public class General {

	public static ArrayList<Jogador> ler()
	{
		String[] v_stringLine;
		ArrayList<Jogador> v_arrayOfJogadores = new ArrayList<>();
		
		
		try {
			File v_file = new File("/tmp/jogadores.txt");
			Scanner v_in = new Scanner(v_file);
			String v_line = v_in.nextLine();
            while (v_in.hasNextLine())
    		{
            	v_line = v_in.nextLine();
    			v_stringLine = v_line.split(",",-1);
    			for(int i = 0; i < v_stringLine.length; i++)
    			{
    				if(v_stringLine[i].equals(""))
    				{
    					v_stringLine[i] = null;
    				}
    			}
    			v_arrayOfJogadores.add(new Jogador(v_stringLine[0],v_stringLine[1],v_stringLine[2],v_stringLine[3],v_stringLine[4],v_stringLine[5],v_stringLine[6],v_stringLine[7]));
    		}
            v_in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
		return v_arrayOfJogadores;
	}
	
	public static void main(String[] args) {
		MyIO.setCharset("UTF-8");
		String v_line;
		ArrayList<Jogador> v_arrayOfJogadores = new ArrayList<>();
		v_arrayOfJogadores = ler();
		v_line = MyIO.readLine();
		while(!v_line.equals("FIM")) {
			for(Jogador t_jogador : v_arrayOfJogadores) {
		        if(t_jogador.getId() == Integer.parseInt(v_line))
		        {
		        	System.out.println(t_jogador.Imprimir());
		        	break;
		        }
			}
			v_line = MyIO.readLine();
		}
	}

}
