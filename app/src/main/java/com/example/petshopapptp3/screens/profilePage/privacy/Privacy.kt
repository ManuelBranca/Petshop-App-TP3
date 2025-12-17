package com.example.petshopapptp3.screens.profilePage.privacy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petshopapptp3.R
import com.example.petshopapptp3.components.shared.ArrowTitle

@Composable
fun PrivacyView(navController: NavController) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            ArrowTitle(stringResource(R.string.privacy)){
                navController.popBackStack()
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.terms_of_use),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = stringResource(R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_mauris_interdum_sapien_sodales_mi_sagittis_hendrerit_curabitur_ut_lectus_nec_orci_cursus_rhoncus_donec_a_ultrices_risus_mauris_ut_erat_ut_urna_rhoncus_facilisis_a_eu_neque_ut_iaculis_viverra_laoreet_in_interdum_augue_non_auctor_pharetra_felis_ante_gravida_ante_quis_mattis_quam_eros_non_quam_vivamus_scelerisque_ante_nec_dapibus_convallis_vestibulum_quis_scelerisque_leo_vestibulum_quis_porttitor_tellus_non_finibus_nibh_quisque_ut_tempor_nulla_sed_consectetur_tortor_mauris_volutpat_viverra_arcu_non_laoreet_duis_eu_arcu_nunc_pellentesque_ultricies_facilisis_faucibus_duis_magna_sem_ultricies_sed_scelerisque_efficitur_hendrerit_at_arcu),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 21.sp,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = "PetApp Service",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 48.dp)
            )

            Text(
                text = stringResource(R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_mauris_interdum_sapien_sodales_mi_sagittis_hendrerit_curabitur_ut_lectus_nec_orci_cursus_rhoncus_donec_a_ultrices_risus_mauris_ut_erat_ut_urna_rhoncus_facilisis_a_eu_neque_ut_iaculis_viverra_laoreet_in_interdum_augue_non_auctor_pharetra_felis_ante_gravida_ante_quis_mattis_quam_eros_non_quam_vivamus_scelerisque_ante_nec_dapibus_convallis_vestibulum_quis_scelerisque_leo_vestibulum_quis_porttitor_tellus_non_finibus_nibh_quisque_ut_tempor_nulla_sed_consectetur_tortor_mauris_volutpat_viverra_arcu_non_laoreet_duis_eu_arcu_nunc_pellentesque_ultricies_facilisis_faucibus_duis_magna_sem_ultricies_sed_scelerisque_efficitur_hendrerit_at_arcu),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 21.sp,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 24.dp)
            )
        }
    }