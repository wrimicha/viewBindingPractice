package sheridan.wrimicha.assignment2.ui.roller

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import sheridan.wrimicha.assignment2.R

class RollerFragment : Fragment() {

    private lateinit var viewModel: RollerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_roller, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RollerViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater) //pass in the menu and the type of inflater
        inflater.inflate(R.menu.menu_roller, menu) //link the menu you want to inflate
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_history -> {
                findNavController().navigate(R.id.action_global_to_history)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}