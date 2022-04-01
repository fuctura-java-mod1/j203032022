package br.com.fuctura;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.imageio.ImageIO;

import br.com.fuctura.dao.FilmeDAO;
import br.com.fuctura.dto.NomeDuracaoDTO;
import br.com.fuctura.model.Filme;
import br.com.fuctura.util.GeneroEnum;

public class TesteConexaoHibernate {

	public static byte [] lerImagem() throws IOException {
		BufferedImage bImage = ImageIO.read(new File("image.png"));
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      ImageIO.write(bImage, "jpg", bos );
	      return bos.toByteArray();
	}
	
	public static void main(String[] args) throws IOException {
				
		Filme novoFilme = new Filme();
		novoFilme.setNome("Vingadores");
		novoFilme.setDuracao(120);
		novoFilme.setLinkyt("yt/7hdyu");
		novoFilme.setClassificacao(12);
		//now = agora! Vai inserir a data de hoje
		novoFilme.setDataDeLancamento(LocalDate.now());
		novoFilme.setImagemDoFilme("TEXTO ALEATORIO".getBytes());
		novoFilme.setGenero(GeneroEnum.AVENTURA);
		
		
		Filme filme2 = new Filme();
		filme2.setNome("Matrix");
		filme2.setDuracao(220);
		filme2.setLinkyt("yt/78j1");
		filme2.setClassificacao(15);
		
		LocalDate dtLancamento = LocalDate.parse("01/03/1999", 
				 							DateTimeFormatter.ofPattern("d/MM/yyyy"));
		filme2.setDataDeLancamento(dtLancamento);

		Filme filme3 = new Filme();
		filme3.setNome("Matrix");
		filme3.setDuracao(220);
		filme3.setLinkyt("yt/78j1");
		filme3.setClassificacao(15);
		
		dtLancamento = LocalDate.parse("01/03/2023", 
				 							DateTimeFormatter.ofPattern("d/MM/yyyy"));
		filme3.setDataDeLancamento(dtLancamento);

		
		 
		FilmeDAO dao = new FilmeDAO();
		
		dao.salvar(novoFilme);
		dao.salvar(filme2);

		//dao.excluir(novoFilme);

		Filme filmeEncontradoNaBase = dao.pesquisar(novoFilme);
		
		if (filmeEncontradoNaBase != null) {
			System.out.println("Duracao: " + filmeEncontradoNaBase.getDuracao());
		}
		
		Filme f = new Filme();
		f.setClassificacao(15);
		
		List<Filme> resultado = dao.pesquisarPorClassificacao(f);
		for(Filme filme : resultado) {
			System.out.println("Nome: " + filme.getNome());
		}
		
		List<Filme> resultado2 = dao.pesquisarPorClassificacao(10, 22);
		for(Filme filme : resultado2) {
			System.out.println("- Nome: " + filme.getNome());
		}
		
		List<Filme> resultado3 = dao.pesquisarPorNome("Vingadores");
		for(Filme filme : resultado3) {
			System.out.println("* Nome: " + filme.getNome());
		}
		
		List<String> nomesDosfilmes = dao.obterTodosOsNomes();
		for(String nomeDoFilme : nomesDosfilmes) {
			System.out.println("* Nome: " + nomeDoFilme);
		}
		
		List<NomeDuracaoDTO> resultadoUtilizandoDTO = dao.obterTodosOsNomesDTO();
		for(NomeDuracaoDTO nomeDuracao : resultadoUtilizandoDTO) {
			System.out.println("* Nome: " + nomeDuracao.getNome());
			System.out.println("* Duracao: " + nomeDuracao.getDuracao());
		}
		
		
		List<Filme> todos = dao.obterTodos();
		for(Filme filme : todos) {
			
			System.out.println(filme.getImagemDoFilme());
			
		}
		
	}

}
