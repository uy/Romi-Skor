//
//  ViewController.swift
//  Romi Skor
//
//  Created by Utku Yeğen on 8.01.2018.
//  Copyright © 2018 Utku Yeğen. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
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
        
        print(self.oyunListesi[indexPath.item])
        cell._oyunAdi = oyunListesi[indexPath.item]
        
        return cell
    }

}

