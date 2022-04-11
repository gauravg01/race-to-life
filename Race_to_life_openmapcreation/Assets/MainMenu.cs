using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MainMenu : MonoBehaviour
{
    public GameObject startCanvas;
    public GameObject charecterCanvas;
    public GameObject[] charecters;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    public void StartButton()
    {
        startCanvas.SetActive(false);
        charecterCanvas.SetActive(true);
        charecters[PlayerPrefs.GetInt("char")].SetActive(true);
    }

    // Update is called once per frame
    void Update()
    {
        
    }
    public void next()
    {
        int i = PlayerPrefs.GetInt("char");
        if(i<charecters.Length-1)
        {
            i++;
        }
        PlayerPrefs.SetInt("char", i);
        for(int j=0;j<charecters.Length;j++)
        {
            charecters[j].SetActive(false);
        }
        charecters[PlayerPrefs.GetInt("char")].SetActive(true);
    }
    public void prev()
    {
        int i = PlayerPrefs.GetInt("char");
        if (i > 0)
        {
            i--;
        }
        PlayerPrefs.SetInt("char", i);
        for (int j = 0; j < charecters.Length; j++)
        {
            charecters[j].SetActive(false);
        }
        charecters[PlayerPrefs.GetInt("char")].SetActive(true);
    }
    public void selectbutton()
    {
        UnityEngine.SceneManagement.SceneManager.LoadScene(1);
    }
}
