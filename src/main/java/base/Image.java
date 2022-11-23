package base;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Image {
    private int width;
    private int height;
    private String[][] bgcolors;
    private String[][] fgcolors;
    private String[][] characters;

    public Image(String file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document document = null;
        try {
            document = builder.parse("src/main/resources/" + file + ".svg");
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Element svg = document.getDocumentElement();
        this.width = Integer.parseInt(svg.getAttributes().getNamedItem("width").getNodeValue()) / 10;
        this.height = Integer.parseInt(svg.getAttributes().getNamedItem("height").getNodeValue()) / 10;

        Node g = document.getDocumentElement().getElementsByTagName("g").item(0);
        NodeList nodeList = g.getChildNodes();

        bgcolors = new String[height][width];
        fgcolors = new String[height][width];
        characters = new String[height][width];

        // Read the XML document
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                int x = Integer.parseInt(elem.getAttributes().getNamedItem("x").getNodeValue()) / 10;
                int y = Integer.parseInt(elem.getAttributes().getNamedItem("y").getNodeValue()) / 10;
                String color = elem.getAttributes().getNamedItem("style").getNodeValue().substring(5, 12);
                characters[y][x] = " ";
                if (node.getNodeName().equals("rect"))
                    bgcolors[y][x] = color;

                else if (node.getNodeName().equals("text")) {
                    fgcolors[y][x] = color;
                    characters[y][x] = elem.getTextContent();
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[][] getBGcolors() {
        return bgcolors;
    }

    public String[][] getFGcolors() {
        return fgcolors;
    }

    public String[][] getCharacters() {
        return characters;
    }
}