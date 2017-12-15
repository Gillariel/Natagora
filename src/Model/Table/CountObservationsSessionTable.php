<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * CountObservationsSession Model
 *
 * @method \App\Model\Entity\CountObservationsSession get($primaryKey, $options = [])
 * @method \App\Model\Entity\CountObservationsSession newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\CountObservationsSession[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\CountObservationsSession|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\CountObservationsSession patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\CountObservationsSession[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\CountObservationsSession findOrCreate($search, callable $callback = null, $options = [])
 */
class CountObservationsSessionTable extends Table
{

    /**
     * Initialize method
     *
     * @param array $config The configuration for the Table.
     * @return void
     */
    public function initialize(array $config)
    {
        parent::initialize($config);

        $this->setTable('count_observations_session');
    }

    /**
     * Default validation rules.
     *
     * @param \Cake\Validation\Validator $validator Validator instance.
     * @return \Cake\Validation\Validator
     */
    public function validationDefault(Validator $validator)
    {
        $validator
            ->requirePresence('Number', 'create')
            ->notEmpty('Number');

        $validator
            ->integer('Sessions_ID')
            ->requirePresence('Sessions_ID', 'create')
            ->notEmpty('Sessions_ID');

        return $validator;
    }
}
