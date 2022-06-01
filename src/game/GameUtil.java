package game;
 
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

//工具类用来存放一些辅助性的方法
public class GameUtil {
    private GameUtil() {
    } 
 
    public static Image getImage(String path) {
        BufferedImage bi = null;
        try {
        	//获得程序运行类加载器，加载资源的根目录，从而获得相对资源位置
            URL u = GameUtil.class.getClassLoader().getResource(path);
            //读取图片信息，并返回Image对象
            bi = ImageIO.read(u);
        } catch (IOException e) {
            System.exit(0);
        }
        return bi;
    }
}