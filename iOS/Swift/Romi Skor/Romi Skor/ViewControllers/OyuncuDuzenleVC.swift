//
//  OyuncuDuzenle.swift
//  Romi Skor
//
//  Created by Utku Yeğen on 9.01.2018.
//  Copyright © 2018 Utku Yeğen. All rights reserved.
//

import UIKit

class OyuncuDuzenleVC: UIViewController {
    
    // MARK : Outlets
    @IBOutlet weak var oyuncu1: UITextField!
    @IBOutlet weak var oyuncu2: UITextField!
    @IBOutlet weak var oyuncu3: UITextField!
    @IBOutlet weak var oyuncu4: UITextField!
    
    // MARK : IB Actions
    @IBAction func duzenle(_ sender: UIButton) {
        RomiSkorAPI.sharedInstance.setOyuncuIsimleri(OyuncuIsimleri(oyuncu1: oyuncu1.text!, oyuncu2: oyuncu2.text!, oyuncu3: oyuncu3.text!, oyuncu4: oyuncu4.text!))
        dismiss(animated: true, completion: nil)
    }
    
    @IBAction func iptal(_ sender: UIButton) {
        dismiss(animated: true, completion: nil)
    }
    
    // MARK : Override Func.s
    override func viewDidLoad() {
        super.viewDidLoad()
        
        NotificationCenter.default.addObserver(self, selector: #selector(self.keyboardWillShow), name: NSNotification.Name.UIKeyboardWillShow, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(self.keyboardWillHide), name: NSNotification.Name.UIKeyboardWillHide, object: nil)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        NotificationCenter.default.removeObserver(self, name: NSNotification.Name.UIKeyboardWillShow, object: self.view.window)
        NotificationCenter.default.removeObserver(self, name: NSNotification.Name.UIKeyboardWillHide, object: self.view.window)
    }
}

