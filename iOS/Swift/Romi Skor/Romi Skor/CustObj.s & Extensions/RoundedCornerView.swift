//
//  RoundedCornerView.swift
//  Romi Skor
//
//  Created by Utku Yeğen on 10.01.2018.
//  Copyright © 2018 Utku Yeğen. All rights reserved.
//

import UIKit

@IBDesignable
class RoundedCornerView: UIView {
    @IBInspectable
    public var cornerRadius: CGFloat = 0.0 {
        didSet {
            self.layer.cornerRadius = self.cornerRadius
        }
    }
}
