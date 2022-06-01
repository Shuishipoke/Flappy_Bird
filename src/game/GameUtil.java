package game;
 
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

//�������������һЩ�����Եķ���
public class GameUtil {
    private GameUtil() {
    } 
 
    public static Image getImage(String path) {
        BufferedImage bi = null;
        try {
        	//��ó����������������������Դ�ĸ�Ŀ¼���Ӷ���������Դλ��
            URL u = GameUtil.class.getClassLoader().getResource(path);
            //��ȡͼƬ��Ϣ��������Image����
            bi = ImageIO.read(u);
        } catch (IOException e) {
            System.exit(0);
        }
        return bi;
    }
}