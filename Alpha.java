/**
     * Aplica el efecto alpha blending
     * combina dos imagenes
     * @param BufferedImage backGround Buffer de la imagen que estará en el fondo
     * @param BufferedImage foreGround Buffer de la imagen que se ubicará en primer plano
     */    
    private BufferedImage writeAlpha(BufferedImage backGround,BufferedImage foreGround) {
        //Crea un buffer de imagen donde se guardará el resultado
        BufferedImage biDestino = new BufferedImage(backGround.getWidth(), backGround.getHeight(), BufferedImage.TYPE_INT_RGB);        
        int r = 0, g = 0, b =0;
        
        for( int y = 0; y < backGround.getHeight(); y++ ){
                
            for( int x = 0; x < backGround.getWidth(); x++ ) {
                //Obtiene el color de la imagen original
                Color c1 = new Color(backGround.getRGB(x, y));
                Color c2 = new Color(foreGround.getRGB(x, y));

                //almacena cada uno de los valores aplicando la formula
                r = (int) ((alpha*c1.getRed())+(1-alpha)*c2.getRed());
                g = (int) ((alpha*c1.getGreen())+(1-alpha)*c2.getGreen());
                b = (int) ((alpha*c1.getBlue())+(1-alpha)*c2.getBlue());
                biDestino.setRGB(x, y, new Color(r, g, b).getRGB());
            }
        }
    
        
        return biDestino;
    }