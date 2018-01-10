//
//  RomiSkor.swift
//  Romi Skor
//
//  Created by Utku Yeğen on 10.01.2018.
//  Copyright © 2018 Utku Yeğen. All rights reserved.
//

import Foundation

/*
struct OyuncuIsimleri {
    var oyuncu1 = ""
    var oyuncu2 = ""
    var oyuncu3 = ""
    var oyuncu4 = ""
}
*/

class OyuncuIsimleri {
    var oyuncu1 = ""
    var oyuncu2 = ""
    var oyuncu3 = ""
    var oyuncu4 = ""
    
    init(oyuncu1: String, oyuncu2: String, oyuncu3: String, oyuncu4: String) {
        self.oyuncu1 = oyuncu1
        self.oyuncu2 = oyuncu2
        self.oyuncu3 = oyuncu3
        self.oyuncu4 = oyuncu4
    }
}

enum UDKeys: String {
    case oyuncu1 = "OyuncuIsimleri.1"
    case oyuncu2 = "OyuncuIsimleri.2"
    case oyuncu3 = "OyuncuIsimleri.3"
    case oyuncu4 = "OyuncuIsimleri.4"
}

class RomiSkorAPI {
    static let sharedInstance = RomiSkorAPI()
    private init() {}
    
    var guncelOyuncuIsimleri = OyuncuIsimleri(oyuncu1: "", oyuncu2: "", oyuncu3: "", oyuncu4: "")
    
    // MARK : Oyuncu Isimleri Funcs
    func getOyuncuIsimleri() -> OyuncuIsimleri {
        let o1 = UserDefaults.standard.string(forKey: UDKeys.oyuncu1.rawValue) ?? "1. Oyuncu"
        let o2 = UserDefaults.standard.string(forKey: UDKeys.oyuncu2.rawValue) ?? "2. Oyuncu"
        let o3 = UserDefaults.standard.string(forKey: UDKeys.oyuncu3.rawValue) ?? "3. Oyuncu"
        let o4 = UserDefaults.standard.string(forKey: UDKeys.oyuncu4.rawValue) ?? "4. Oyuncunes"
        return OyuncuIsimleri(oyuncu1: o1, oyuncu2: o2, oyuncu3: o3, oyuncu4: o4)
    }
    
    func setOyuncuIsimleri(_ oyuncuIsimleri: OyuncuIsimleri) {
        UserDefaults.standard.set(oyuncuIsimleri.oyuncu1, forKey: UDKeys.oyuncu1.rawValue)
        UserDefaults.standard.set(oyuncuIsimleri.oyuncu2, forKey: UDKeys.oyuncu2.rawValue)
        UserDefaults.standard.set(oyuncuIsimleri.oyuncu3, forKey: UDKeys.oyuncu3.rawValue)
        UserDefaults.standard.set(oyuncuIsimleri.oyuncu4, forKey: UDKeys.oyuncu4.rawValue)
    }
    
    
    // MARK : guncelOyuncuIsimleri
    func updateGuncelOyuncuIsimleri() {
        self.guncelOyuncuIsimleri = getOyuncuIsimleri()
    }
}
