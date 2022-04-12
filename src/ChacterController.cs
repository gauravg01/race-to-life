using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Cinemachine;
public class ChacterController : MonoBehaviour
{
    public CinemachineVirtualCamera cinemachineVirtual;
    public GameObject[] camerarroot;
    public GameObject[] players;
    private void Awake()
    {
        cinemachineVirtual.Follow = camerarroot[PlayerPrefs.GetInt("char")].transform;
        players[PlayerPrefs.GetInt("char")].SetActive(true);
    }
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        //if(Input.GetKey(KeyCode.Backspace))
        //{
        //    UnityEngine.SceneManagement.SceneManager.LoadScene(0);
        //}
    }
    public void back()
    {
        UnityEngine.SceneManagement.SceneManager.LoadScene(0);
    }
}
