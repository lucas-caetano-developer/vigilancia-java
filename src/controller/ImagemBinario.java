package controller;

import javax.swing.*;

import model.Idiomas;

import java.awt.*;
import java.io.*;

public class ImagemBinario {
	
	private Idiomas idiomas = new Idiomas();
	
	public ImagemBinario() {
		
	}

    // Método que abre o JFileChooser para o usuário escolher a imagem e depois a converte para binário
    public byte[] imagem(int idioma) {
    	
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif", "bmp"));
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String imagePath = selectedFile.getAbsolutePath();

            try {
                byte[] imageBytes = imageToBinary(imagePath, idioma);
                
                JOptionPane.showMessageDialog(null, idiomas.getImagemMenssageConvertida(idioma) + imageBytes.length + " bytes");
                return imageBytes;
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
        	JOptionPane.showMessageDialog(null, idiomas.getImagemMenssageSemSelecao(idioma), "", JOptionPane.WARNING_MESSAGE);
        }
		return null;
    }

    // Método para converter a imagem em binário (byte[])
    private byte[] imageToBinary(String imagePath, int idioma) throws IOException {
        File file = new File(imagePath);

        if (!file.exists()) {
            throw new FileNotFoundException(idiomas.getImagemMenssageRetorno(idioma) + imagePath);
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] byteArray = new byte[(int) file.length()]; 
            fis.read(byteArray); 
            return byteArray;  // Retorna o array de bytes
        }
    }
    
    public ImageIcon exibirImagem(byte[] imagemBinaria) {
        if (imagemBinaria != null) {
        	
            ImageIcon imagemIcon = new ImageIcon(imagemBinaria);
            
            // Conversão
            Image imagem = imagemIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            imagemIcon = new ImageIcon(imagem);
            return imagemIcon;
                     
        } 
		return null;
    }

}
