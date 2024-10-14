import {Component, inject, OnInit} from '@angular/core';
import {FaConfig, FaIconLibrary} from "@fortawesome/angular-fontawesome";
import {fontAwesomeIcons} from "./shared/fontAwesomeIcons";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

  private faIconLibrary = inject(FaIconLibrary);
  private faConfig = inject(FaConfig);

  ngOnInit(): void {
    this.initFontAwesome();
  }

  private initFontAwesome() {
        this.faConfig.defaultPrefix = "far";
        this.faIconLibrary.addIcons(...fontAwesomeIcons);
    }
}
