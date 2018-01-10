//
//  ViewController.swift
//  Romi Skor
//
//  Created by Utku Yeğen on 8.01.2018.
//  Copyright © 2018 Utku Yeğen. All rights reserved.
//

import UIKit

class RomiSkorVC: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    // MARK : Custom Variables
    let oyunListesi = ["3'lü Küt",
                        "3'lü Seri",
                        "3'lü Küt 3'lü Seri",
                        "4'lü Küt",
                        "4'lü Seri",
                        "4'lü Küt 3'lü Seri",
                        "3'lü Küt 4'lü Seri",
                        "4'lü Küt 4'lü Seri",
                        "4'lü Küt 4'lü Küt",
                        "4'lü Seri 4'lü Seri",
                        "5'lü Seri",
                        "5'lü Seri 3'lü Küt",
                        "5'lü Seri 4'lü Küt",
                        "5 Çift",
                        "Elden Bitme"]

    // MAKR : References
    @IBOutlet weak var table: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.hideKeyboardWhenTappedAround()
        
        self.table.delegate = self
        self.table.dataSource = self
        
        NotificationCenter.default.addObserver(self, selector: #selector(self.keyboardWillShow), name: NSNotification.Name.UIKeyboardWillShow, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(self.keyboardWillHide), name: NSNotification.Name.UIKeyboardWillHide, object: nil)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        NotificationCenter.default.removeObserver(self, name: NSNotification.Name.UIKeyboardWillShow, object: self.view.window)
        NotificationCenter.default.removeObserver(self, name: NSNotification.Name.UIKeyboardWillHide, object: self.view.window)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    // MARK : Table View Data Source
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.oyunListesi.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "gameRowCell") as! GameRowCell
        
        if indexPath.item == 0 {
            RomiSkorAPI.sharedInstance.updateGuncelOyuncuIsimleri()
        }
        let oyuncuIsimleri = RomiSkorAPI.sharedInstance.getOyuncuIsimleri()
        
        cell._oyunAdi = oyunListesi[indexPath.item]
        cell._oyuncu1 = oyuncuIsimleri.oyuncu1
        cell._oyuncu2 = oyuncuIsimleri.oyuncu2
        cell._oyuncu3 = oyuncuIsimleri.oyuncu3
        cell._oyuncu4 = oyuncuIsimleri.oyuncu4
        
        return cell
    }

}

