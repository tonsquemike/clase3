 private BufferedImage Difference( BufferedImage img1, BufferedImage img2){
        int r,g,b;
        int r1 = 0, g1 = 0, b1 = 0, diferencia = 0;
        
        //Recorrer las imagenes y obtiene el color de la imagen original y la almacena en el destino con tonalidad en grises<
        for( int x = 0; x < img1.getWidth(); x++ )
        {
            for( int y = 0; y < img1.getHeight(); y++ ) 
            {
                //Obtiene el color de la imagen original
                Color c1 = new Color(img1.getRGB(x, y));
                Color c2 = new Color(img2.getRGB(x, y));
                //almacenar los valores RGB de cada pixel individualmente
                if( (r = c1.getRed  ()-c2.getRed())<0 )
                    r = 0;
                if( (g = c1.getGreen()-c2.getGreen())<0 )
                    g = 0;
                if( (b = c1.getBlue ()-c2.getBlue())<0 )
                    b = 0;
                //almacena cada uno de los valores aplicando la formula
                img1.setRGB(x, y, new Color(r, g, b).getRGB());
                
                r1 += r;
                g1 += g;
                b1 += b;
            }
        }
        int dif = (r1+g1+b1)/3;
        System.out.println("dif: "+dif);
        return img1;    
    }