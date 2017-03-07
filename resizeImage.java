/**
* @param biImg - source image to scale
* @param w - desired width
* @param h - desired height
* @return - the new resized image
*/
private BufferedImage getScaledImage(BufferedImage bi, int w, int h){
    int finalw = w;
    int finalh = h;
    double factor = 1.0d;
    if(bi.getWidth() > bi.getHeight()){
        factor = ((double)bi.getHeight()/(double)bi.getWidth());
        finalh = (int)(finalw * factor);                
    }else{
        factor = ((double)bi.getWidth()/(double)bi.getHeight());
        finalw = (int)(finalh * factor);
    }   

    BufferedImage bo = new BufferedImage(finalw, finalh, BufferedImage.TRANSLUCENT);
    Graphics2D g2 = bo.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(bi, 0, 0, finalw, finalh, null);
    g2.dispose();
    return bo;
}