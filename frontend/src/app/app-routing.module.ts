import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HealthCheckComponent} from "./healthcheck/component/health-check.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";

const routes: Routes = [
    {
      path: '',
      component: HealthCheckComponent,
      pathMatch: 'full'
    },
    {path: '**', component: PageNotFoundComponent}
  ]
;

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}