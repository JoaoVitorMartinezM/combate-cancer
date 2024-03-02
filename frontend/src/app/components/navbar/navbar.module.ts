import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NavbarComponent} from "./navbar.component";
import {MatToolbarModule} from "@angular/material/toolbar";
import {RouterModule} from "@angular/router";
import {DragDropModule} from "@angular/cdk/drag-drop";


@NgModule({
  declarations: [
    NavbarComponent
  ],
    imports: [
        CommonModule,
        MatToolbarModule,
        RouterModule,
        DragDropModule
    ]
})
export class NavbarModule {
}
