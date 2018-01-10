//
//  GameRow.swift
//  Romi Skor
//
//  Created by Utku Yeğen on 9.01.2018.
//  Copyright © 2018 Utku Yeğen. All rights reserved.
//

import UIKit

class GameRowCell: UITableViewCell {
    @IBOutlet weak var oyunAdi: UILabel!
    
    @IBOutlet weak var oyuncu1: UILabel!
    @IBOutlet weak var oyuncu2: UILabel!
    @IBOutlet weak var oyuncu3: UILabel!
    @IBOutlet weak var oyuncu4: UILabel!
    
    var _oyunAdi = "" {
        didSet{
            self.oyunAdi.text = self._oyunAdi
        }
    }
    
    var _oyuncu1 = "" {
        didSet {
            self.oyuncu1.text = self._oyuncu1
        }
    }
    
    var _oyuncu2 = "" {
        didSet {
            self.oyuncu2.text = self._oyuncu2
        }
    }
    
    var _oyuncu3 = "" {
        didSet {
            self.oyuncu3.text = self._oyuncu3
        }
    }
    
    var _oyuncu4 = "" {
        didSet {
            self.oyuncu4.text = self._oyuncu4
        }
    }
}
