<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * ObservationBird Model
 *
 * @method \App\Model\Entity\ObservationBird get($primaryKey, $options = [])
 * @method \App\Model\Entity\ObservationBird newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\ObservationBird[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\ObservationBird|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\ObservationBird patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\ObservationBird[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\ObservationBird findOrCreate($search, callable $callback = null, $options = [])
 */
class ObservationBirdTable extends Table
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

        $this->setTable('observation_bird');
        $this->setDisplayField('Observation_ID');
        $this->setPrimaryKey(['Observation_ID', 'Bird_ID']);
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
            ->integer('Observation_ID')
            ->allowEmpty('Observation_ID', 'create');

        $validator
            ->integer('Bird_ID')
            ->allowEmpty('Bird_ID', 'create');

        return $validator;
    }
}
