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
    
    var _oyunAdi: String {
        get{
            return self._oyunAdi
        }
        set(v) {
            self.oyunAdi.text = v
        }
    }
}
