/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Emma
 */

public class Pokemon {
    private String name;
    private String image;
    private int id;

    public Pokemon() {}

    
    public String getName() { return name; }
    public String getImage() { return image; }
    public int getId() { return id; }

    public void setName(String name) { this.name = name; }
    public void setImage(String image) { this.image = image; }
    public void setId(int id) { this.id = id; }
}
